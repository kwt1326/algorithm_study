# !bin/bash

file=$1
out=$2

mkdir -p dist
g++ -std=c++14 -Wall $file -o ./dist/$out.out
./dist/$out.out
