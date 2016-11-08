# Task 02

Create an application exploring devices in your network. An Adroid Studio project should contain two modules:

#### Module 1

This module has an activity containing simple list view of discovered devices (names and IP addresses) and two inputs:

* interval - time in seconds before next scan runs
* device name - a name that identifies current device

There is also a broadcast receiver that takes care of new devices delivered from the discovery service bound to the activity.

#### Module 2

The other module will contain a discovery service and a listener service. Once it's started the discovery service sends a UDP broadcast (on any port number you choose) and waits for results. When the listener service receives a broadcast it should response with some string constant and a device name (e.g. "MYSVC Tablet1"). When the discovery service receives the response sends it via a broadcast intent to the activity.

Once you're done save you work to Github and send us an email with a link to the project. Thanks :-)