#!/bin/sh
# Checks for prohibited line endings.
# Prohibited line endings: \r\n

git grep --cached -I -n --no-color -P '\r$' -- ':/' |
# We want to allow .bat files to have \r\n line endings,
# since these batch scripts are run on Windows.
awk '
    BEGIN {
        FS = ":"
        OFS = ":"
        ret = 0
    }
    !($1 ~ /\.bat$/) {
        ret = 1
        print "ERROR", $1, $2, " prohibited \\r\\n line ending, use \\n instead."
    }
    END {
        exit ret
    }
'
