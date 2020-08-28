#!/bin/sh
for files in $(ls *.png)
    do mv $files "huojian_"$files
done
