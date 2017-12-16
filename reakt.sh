#!/usr/bin/env bash
#build front js,css,html
cd ./front
nowa build
cd ../
#cp js,css,html to /templates, /static
kotlinc -script reakt.kts
#gradle bootRun
gradle bootRun
