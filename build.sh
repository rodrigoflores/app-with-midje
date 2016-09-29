#!/bin/sh

rm -rf xxx-yyy
lein install
mv profiles.clj.example profiles.clj
lein new app-with-midje xxx-yyy
cd xxx-yyy
lein midje
