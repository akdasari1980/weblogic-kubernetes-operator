#!/bin/bash
# Copyright 2017, Oracle Corporation and/or its affiliates.  All rights reserved.
# Licensed under the Universal Permissive License v 1.0 as shown at http://oss.oracle.com/licenses/upl.

test `find /operator/.alive -mmin -1`

if(($?==0)); then
    exit 0
else 
    exit 1
fi



