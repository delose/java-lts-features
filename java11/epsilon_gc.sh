#!/bin/bash

java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xmx2g -Xlog:gc* com.delose.lts.java11.EpsilonGCExample