% Matrix contains:
% - Model Values (Static) - 
% [1] = V : Desired velocity
% [2] = S : Minimum Spacing
% [3] = T : Desired Time Headway
% [4] = A : Acceleration
% [5] = B : Comfortable Deacceleration
% [6] = delta : Exponent of Acceleration
% [7] = sqrtAB : static root of A * B
% [8] = L : length of a vehicle
% - Dynamic Values - 
% [9] = cV : current Speed
% [10] = P : Position on Road
V=33;
S=2;
T=2;
A=0.2;
B=0.2;
delta = 4;
sqrtAB = sqrt(A*B);
L = 5;

% CarTypeX = [V,S,T,A,B,delta,sqrtAB, L]
carTypeDummy = [0, 0, 0, 0, 0, 0, 0, 0]; % Trafficlight, or something else that's not moving
carTypeA = [V, S, T, A, B, delta, sqrtAB, L]; % A normal car
carTypeB = [20, 2, 2, 0.2, 0.2, delta, sqrtAB, 20]; % A truck

% roadMatrix = [CarTypeX cV P; CarTypeX cV P; ......]
roadMatrix = [carTypeDummy, 0, 0; carTypeDummy, 0, 500; carTypeB, 0, 0];

% The actual model

dT = 1;

for i=1:1000
    a = 1:(size(roadMatrix, 1)-1); % everything in a certain column except for the last one
    b = 2:size(roadMatrix, 1); % everything in a certain column except for the dummy
    position = roadMatrix(: , 10);
    speed = roadMatrix(: , 9);
    length = roadMatrix(: , 8);    

    delta_v = speed(b) - speed(a); % The difference in speeds between every car and its predecessor in the roadMatrix
    s = position(a) - position(b) - length(b); % The position of the cars in respect to its predecessor
    velocity = speed(b); % every current velocity of every car except the dummy
    minimumDist = roadMatrix(b, 2) + velocity.*roadMatrix(b, 3) + (velocity.*delta_v)./(2*roadMatrix(b, 7));  
    minimumDist(minimumDist < roadMatrix(b, 2)) = roadMatrix(minimumDist < roadMatrix(b, 2), 2); % the checking which cars need to get an adjustment and putting them back to the minimumdistance
    accelerations = roadMatrix(b, 4).*(1 - (velocity./roadMatrix(b, 1)).^roadMatrix(2:end, 6)) - (minimumDist.*minimumDist)./(s.*s); % the changing of every vehicles accaleration

    accelerations(isnan(accelerations)) = 0; % tip van GJ om te zorgen dat er niets raars gebeurd als het 0 is...

    roadMatrix(b, 10) = position(b) + (speed(b)*dT); % updating the positions
    roadMatrix(b, 9) = speed(b) + accelerations; % updating the current speeds

    roadMatrix(roadMatrix(:, 9) < 0, 9) = 0; % making sure that the cars don't go backwards when they've reached standstill

    plot(position, 0, '*'); % plot van links naar rechts
%     hold on
%     plot(0, position, '*'); % plot van onder naar boven
%     hold on
%     plot(-position, 0, '*'); % plot van rechts naar links
%     hold on
%     plot(0, -position, '*'); % plot van boven naar onder
%     hold off
    pause(1/20);

    % make sure that every 50 steps a new car takes of
    if(mod(i, 50) == 0)
        roadMatrix = [roadMatrix ; carTypeA 0 0];
    end
%     if(mod(i, 25) == 0)
%         roadMatrix = [roadMatrix ; carTypeB 0 0];
%     end
    
%     if(i>50)
%         roadMatrix(2, 10) = 1000;
%     end
%     
end