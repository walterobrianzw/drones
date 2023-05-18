# drones

[[_TOC_]]

---

:scroll: **START**


### Introduction

There is a major new technology that is destined to be a disruptive force in the field of transportation: **the drone**. Just as the mobile phone allowed developing countries to leapfrog older technologies for personal communication, the drone has the potential to leapfrog traditional transportation infrastructure.

Useful drone functions include delivery of small items that are (urgently) needed in locations with difficult access.

---

### Task description

We have a fleet of **10 drones**. A drone is capable of carrying devices, other than cameras, and capable of delivering small loads. For our use case **the load is medications**.

A **Drone** has:
- serial number (100 characters max);
- model (Lightweight, Middleweight, Cruiserweight, Heavyweight);
- weight limit (500gr max);
- battery capacity (percentage);
- state (IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING).

Each **Medication** has: 
- name (allowed only letters, numbers, ‘-‘, ‘_’);
- weight;
- code (allowed only upper case letters, underscore and numbers);
- image (picture of the medication case).

Develop a service via REST API that allows clients to communicate with the drones (i.e. **dispatch controller**). The specific communicaiton with the drone is outside the scope of this task. 

The service should allow:
- registering a drone;
- loading a drone with medication items;
- checking loaded medication items for a given drone; 
- checking available drones for loading;
- check drone battery level for a given drone;

> Feel free to make assumptions for the design approach. 

---

### Requirements

While implementing your solution **please take care of the following requirements**: 

#### Functional requirements

- There is no need for UI;
- Prevent the drone from being loaded with more weight that it can carry;
- Prevent the drone from being in LOADING state if the battery level is **below 25%**;
- Introduce a periodic task to check drones battery levels and create history/audit event log for this.

---

#### Non-functional requirements

- Input/output data must be in JSON format;
- Your project must be buildable and runnable;
- Your project must have a README file with build/run/test instructions (use DB that can be run locally, e.g. in-memory, via container);
- Required data must be preloaded in the database.
- JUnit tests are optional but advisable (if you have time);
- Advice: Show us how you work through your commit history.

---


#### Assupmtions

-	A drone only carries medication for one client
-	When a drone is registered it is set its state as IDLE initially and its weight limit
    Is used to decide its model type eg
        0-200 is lightweight,
        200-300 is middleweight,
        300-400 is Cruiserweight
        400-500 is Heavy weight

#### Implementation and Configuration

    I have chosen H2 database, in-memory variant which is volatile, and the data is lost on application restart. I import dummy data to populate the Drones and the startup the service that checks battery levels. It works in 2 minute intervals 
    Log file for the periodic battery check is saved to the 'logs' subfolder within the project directory.

#### Rest EndPoints
 CONTENT TYPE: JSON
•	Drone Endpoint
•	Medication Endpoint







## Drone Endpoint
Url             : /drones
Method Type     : GET
Response        :List of all Drones object

Url             : /drones/{id}
Parameter Type  : Long int
Method Type     : GET
Response        : A specific Drone object

Url             : /drones/batterycapacity/{id}
Parameter Type  : Long int
Method Type     : GET
Response        : An int value

Url             : /drones/state/{id}
Parameter Type  : Long int
Method Type     : GET
Response        : An Enumarted String value

Url             : /drones/load/{id}
Parameter Type  : Long int
Method Type     : GET
Response        :List of Medication objects of a specific Drone

Url             : /drones/load/
Method Type     : POST
Request         : List of Medication objects
Action          : Load a Drone with Medication
List of Medication objects
[{
    "name":"Pain_Ease",
    "weight":175,
    "code":"1232YWE",
    "image":"1029383784"
},{
    "name":"Mosquito_Coil",
    "weight":5,
    "code":"198273YWE",
    "image":"1029383784"
}]

Url             : /drones
Method Type     : POST
Request         : Drone object
Action          : Register a Drone

Url             : /drones
Method Type     : PUT
Request         : Drone object
Action          : Update a Drone

Url             : /drones/{id}
Parameter Type  : Long int
Method Type     : DELETE
Action          : Delete Drone 


## Medication Endpoint
Url             : /medications
Method Type     : GET
Response        :List of all Medications object

Url             : /medications/{id}
Parameter Type  : Long int
Method Type     : GET
Response        : A specific Medication object

Url             : /medications
Method Type     : POST
Request         : Medication object
Action          : Create a Medicatioon object
Medication Object

{
    "name":"Mosquito_Coil",
    "weight":5,
    "code":"198273YWE",
    "image":"1029383784"
}

Url             : /medications
Method Type     : PUT
Request         : Drone object
Action          : Update a Medication

Medication Object

{
    "name":"Mosquito_Coil",
    "weight":5,
    "code":"198273YWE",
    "image":"1029383784"
}

Url             : /medications/{id}
Parameter Type  : Long int
Method Type     : DELETE
Action          : Delete Medication 




:scroll: **END** 
