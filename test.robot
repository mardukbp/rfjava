*** Settings ***
Library    Remote

*** Variables
@{ints}    ${1}    ${2}    ${3}


*** Test Cases ***
First Test
    Sum ints    3    5
    Sum list    ${ints}
