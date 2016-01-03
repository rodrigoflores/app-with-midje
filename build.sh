#!/bin/sh

rm -rf xxx
lein install
lein new app-with-midje xxx
cd xxx
lein midje
cd ..

