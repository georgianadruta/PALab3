# Laboratory 3
## The Tourist Trip Planning Problem
This repository contains all the problems proposed for the third laboratory in Advanced Programming course solved by me.

# Essentials tools
You need to have Java RE or JDK >= 8 installed on your computer.

# Build and run the above programs
Launch IntelliJ IDEA and click ▶️ in the gutter and select Run 'Main()' in the popup. The IDE starts compiling your code. When the compilation is complete, the Run tool window opens at the bottom of the screen.

# Tasks
The Tourist Trip Planning Problem
A tourist is about to visit a city. In this city, there are various locations such as tourism sites, hotels and restaurants, parks, etc. Locations have names and may have other common properties (such as a description, an image, coordinates, etc). Depending on its type, each location has various specific properties. However, if the location is a visitable, it must have opening hours. If the location is payable, it must have the entry fee (the price of the ticket). If the location is classifiable, it must have a classification (a rank).
The time (in minutes) required to go from one location to another is known. The tourist has also preferences regarding the order in which he (or she) would like to visit some locations.
```
Example: locations are: v1 (Hotel) v2 (Museum A) v3 (Museum B) v4 (Church A) v5 (Church B) v6 (Restaurant).
From-To	Cost
v1→v2	10
v1→v3	50
v2↔v3	20
v2→v4	20
v2→v5	10
v3→v4	20
v4↔v5	30
v4→v6	10
v5→v6	20
```
The main specifications of the application are:

## Compulsory
- [x] Create an object-oriented model of the problem. You should have at least the following classes City, Hotel, Museum, Church, Restaurant. The natural ordering of their objects is given by their names.
- [x] Create the interfaces Visitable, Payable, Classifiable. The classes above must implement these interfaces accordingly.
- [x] The City class will contain a List of locations.
- [x] Each location will contain a Map representing the times required to go from this location to others.
- [x] Create all the objects given in the example.

### Output
```
Hotel Ritz Paris -> The Louvre Museum  : 10
Hotel Ritz Paris -> Picasso Museum : 50
The Louvre Museum  -> Church of Saint-Eustache : 10
The Louvre Museum  -> Notre-Dame de Paris Cathedral : 20
The Louvre Museum  -> Picasso Museum : 20
Picasso Museum -> The Louvre Museum  : 20
Picasso Museum -> Notre-Dame de Paris Cathedral : 20
Notre-Dame de Paris Cathedral -> Church of Saint-Eustache : 30
Notre-Dame de Paris Cathedral -> Le Jules Verne Restaurant : 10
Church of Saint-Eustache -> Le Jules Verne Restaurant : 20
Church of Saint-Eustache -> Notre-Dame de Paris Cathedral : 30

Array before sorting is:
Hotel Ritz Paris
The Louvre Museum 
Picasso Museum
Notre-Dame de Paris Cathedral
Church of Saint-Eustache
Le Jules Verne Restaurant

Array after sorting by name using comparator interface is:
Church of Saint-Eustache
Hotel Ritz Paris
Le Jules Verne Restaurant
Notre-Dame de Paris Cathedral
Picasso Museum
The Louvre Museum 

Array after sorting by name using comparable interface is:
Church of Saint-Eustache
Hotel Ritz Paris
Le Jules Verne Restaurant
Notre-Dame de Paris Cathedral
Picasso Museum
The Louvre Museum 

Process finished with exit code 0
```

## Optional 
- [x] In the City class, create a method to display the locations that are visitable and are not payable, sorted by their opening hour.
- [x] Create default methods in the interface Visitable, with the opening hour 09:30 and the closing hour 20:00.
- [x] Create a static method getVisitingDuration,in the interface Visitable, that returns a Duration object, representing how long a location is opened during a day.
- [x] Create the class TravelPlan. An instance of this class will contain a city and the preferences regarding the visiting order.
- [x] Implement an efficient agorithm to determine the shortest path between two given locations, conforming to the preferences.
### Output
```
From    ->  to  | Cost
Hotel Ritz Paris -> The Louvre Museum  : 10
Hotel Ritz Paris -> Picasso Museum : 50
The Louvre Museum  -> Church of Saint-Eustache : 10
The Louvre Museum  -> Notre-Dame de Paris Cathedral : 20
The Louvre Museum  -> Picasso Museum : 20
Picasso Museum -> The Louvre Museum  : 20
Picasso Museum -> Notre-Dame de Paris Cathedral : 20
Notre-Dame de Paris Cathedral -> Le Jules Verne Restaurant : 10
Notre-Dame de Paris Cathedral -> Church of Saint-Eustache : 30
Church of Saint-Eustache -> Le Jules Verne Restaurant : 20
Church of Saint-Eustache -> Notre-Dame de Paris Cathedral : 30

The locations that are visitable and are not payable, sorted by their opening hour are:
Church of Saint-Eustache
Notre-Dame de Paris Cathedral

The location Hotel Ritz Paris is opening for 14:00 hours

The preference list is:
0 The Louvre Museum 
1 Notre-Dame de Paris Cathedral
2 Picasso Museum
2 Hotel Ritz Paris
4 Le Jules Verne Restaurant
5 Church of Saint-Eustache

The shortest path from Hotel Ritz Paris toChurch of Saint-Eustache is:
Hotel Ritz Paris --> The Louvre Museum  --> Church of Saint-Eustache --> cost = 40

Process finished with exit code 0

```
## Bonus
- [x] Suppose that the tourist has a specific number of days available to visit the city and every day he (or she) has the same number of minutes available for visiting.
- [x] Suppose that there is a special start location (the hotel) - the tourist must start and end a daily trip in this location. (- just start from the hotel)
- [x] Implement an algorithm that will create a plan (a trip for each day), such that the tourist visits as many locations as possible. (- create a single trip)
- [x] Test your algorithm using JUnit or other framework.
### Output
```
Enter the number of days available to visit the city.
1
Enter the number of minutes available for visiting.
80
Hotel Ritz Paris --> The Louvre Museum  --> Picasso Museum --> Notre-Dame de Paris Cathedral --> Church of Saint-Eustache --> 80
```
Test my searchPath method using JUnit:
```
Hotel Ritz Paris --> The Louvre Museum  --> Picasso Museum --> Notre-Dame de Paris Cathedral --> 50

Process finished with exit code 0
```
