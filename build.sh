#!/bin/sh

rm -rf xxx
lein install
lein new app-with-midje xxx-yyy
cd xxx
lein midje
