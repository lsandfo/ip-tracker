# IP-Tracker
Track the IP of a Domain
---
## Description
A Tracker to trace down the IP of a given domain and save the results with the actuall date.
In the actull version, the results are writen down in a log file, seperated by tabs in the following schema:
```
date    ip  domain
```

## Usecases
This is usefull if you need to track down changes on a domains used IP Address, for example if you work with DynDNS or something and needs to know if something change in the background.

## Manuale
In this moment, you just need to start the java file with the wanted domain as only argument:

```shell
java IPTracker.java example.com
```

