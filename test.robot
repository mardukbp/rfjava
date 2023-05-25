*** Settings ***
Library    Remote

*** Test Cases ***
Sum two integers
    ${result}    Sum ints    3    5
    Should Be Equal As Integers    ${result}    8

Sum the integers in a list
    ${ints}      Create List    ${1}    ${2}    ${3}
    ${result}    Sum list       ${ints}
    Should Be Equal As Integers    ${result}    6

Concatenate two strings
    ${result}    Concat Strings    hello    world
    Should Be Equal As Strings    ${result}    helloworld

Concatenate a list of strings
    ${strings}    Create List    Hello    World
    ${result}    Concat List    ,    ${strings}
    Should Be Equal As Strings    ${result}    Hello,World
    