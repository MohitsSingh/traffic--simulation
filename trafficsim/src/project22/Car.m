
% een auto bestaat een locatie een type en een snelheid. Type wordt in een
% andere vector beschreven.

Ncars = 13;

LOK = 1;
VIT = 2;
TPE = 3;

LoC = 20; % The length of a car
WoC = 10; % The width of a car

car = [1; 20; 1];
car2 = car;
car2(1) = car2(1) +30;
cars = [car car2];

for i=0:10
    car2(1) = car2(1) + 30;
    cars = [cars car2];
end
%cars = [1 + 30*(0:Ncars-1); 20* ones(1:Ncars); ones(1:Ncars)];

cars  % 13 cars

cars(2,7) = 30;
cars(2,3) = 25;

%hier worden de nieuwe lokaties van de autos berekend door de snelheid die
%ze rijden erbij in te nemen. Ze berekenen het voor 10 timesteps, dus 10
%timesteps verder (dus als je 20 m/s rijdt, gaat het in deze loop 200 m
%verder.

%for i=1:10
 %   lokatieX = cars(LOK, 1:Ncars);
  %  snelheidX = cars(VIT, 1:Ncars);                  
   % newlocation = lokatieX + snelheidX;
    %cars(1, : ) = newlocation;
%end
cars(LOK,:) = cars(LOK,:) + cars(VIT,:);

cars
% Drawing cars
for i=1:2
   if (i == 2) 
       cars(LOK,:) = cars(LOK,:) + cars(VIT,:);
   end
    for i=1:5
        LoK = cars(LOK, i)
        rectangle('Position', [LoK, 0, LoC, WoC])
    end
end 


% Follow-the-leader model

WoC = 10; % The width of a car
dt = 1/10; %dt dus.
LoC = 20; % The length of a car
NoC = 100; % The number of cars
initSp = LoC; % Initial spacing between the cars
Pos = 0 : initSp : NoC*initSp; % The initial positions of each car
s = diff(Pos); % initial differences
Vallowed = 30; % The speed limit of the road
V = 30; % equilibrium velocity, the velocity every car wants to reach at a certain point
Tr = 1; % relaxation time, the reaction time of different drivers, for now, set to one
relax = 5; % acceleration constant

u = [Vallowed*(1-LoC./s), Vallowed];
v = 0*u;
t=0;
P = 250; % The number of calculations to do
a = v-u;
e1 = exp(-dt/relax);

for i = 1:P %%/dt
    Pos = Pos+v*dt; % the position of the car after one calculation
    s = diff(Pos);  % the difference between the cars after one calculation
    r = 1./s;       
    u = [Vallowed*(1-LoC./s), Vallowed];    % different speeds
    a = a*e1;       % accaleration
    v1 = u+a;       % new speeds
    ww = (v1-v)/dt; % speeddifference
    v = v1;         
    a = v-u;
    t = t+dt;
end
Pos
u

