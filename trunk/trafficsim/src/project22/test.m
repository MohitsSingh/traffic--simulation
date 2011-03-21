%Author: Sara van de Moosdijk
%The purpose of this file is to test the combination of Java graphics with
%Matlab. To avoid massive amounts of random errors I'm going to make this
%as simple as possible. All I want to do is open a frame. Should be easy
%enough right?

%First I need to put the java class I created into some sort of dynamic path. I don't
%have a clue what this is about, which probably explains why this seems to
%be so difficult to achieve.
setdynpath;

javaclasspath
%Rather surprisingly that worked! So now I should be able to use the java
%classes in the folder...

x = project22.Main
%FINALLY!