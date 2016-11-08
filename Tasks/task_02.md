# Task 02

Create an application exploring devices in your network. An Adroid Studio project should contain two modules:

#### Module 1

This module has an activity containing two text boxes:

* interval - time in seconds before next scan runs
* device name - a name that identifies current device

"Start" button placed below should start a discovery service.

#### Module 2

The other module will contain a discovery service. Once started the discovery service sends a UDP broadcast (on any port number you choose) and waits for results. 
When the client receives a broadcast it should respond with some string constant and a device name (e.g. "EXAMPLE Name1"). 

Simple: The response from the client is logged (IP address and a device name).
Challenging: The activity receives an intent with scan results and displays them as simple text.

Are you done? Save you work to Github and email us a link to the project. Thanks :-)