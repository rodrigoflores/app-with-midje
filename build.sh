#!/bin/sh

rm -rf xxx-yyy
lein install
lein new app-with-midje xxx-yyy
cd xxx-yyy
lein midje
