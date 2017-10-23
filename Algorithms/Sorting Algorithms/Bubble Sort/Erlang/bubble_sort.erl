-module(bubble_sort).
-export([main/0, bubble_sort/1]).

main() ->
    test1(),
    test2().   

bubble_sort(Array) ->
    Length = length(Array),
    %% Start at index 1, Keep track of length, initialise total number and number of swaps to 0
    bubble_sort(Array, 1, Length, {0,0}).

%% Using pattern matching
%% We are finished when index is at the end, and we have made no swaps
bubble_sort(Array, Length, Length, {FinalCount, 0}) ->
    {Array, FinalCount};

%% If we are at the end and we have made some swaps, bubble sort again from the beginning
bubble_sort(Array, Length, Length, {FinalCount, _Count}) ->
    bubble_sort(Array, 1, Length, {FinalCount, 0});

bubble_sort(Array, X, Length, {FinalCount, Count}) ->
    %% Get first 2 values of the array
    [Val1, Val2] = lists:sublist(Array, X, 2),
    %% Swap if first value is bigger than second, else increment index
    {NewArray, NewCount} = case Val1 > Val2 of
        true -> {swap(Array, X), {FinalCount+1, Count+1}};
        false -> {Array, {FinalCount, Count}}
    end,
    bubble_sort(NewArray, X+1, Length, NewCount).

%% Return an array where the index value is swapped with the value after it
swap(Array, Index) ->
    {BeforeIndex, [Value1, Value2 | AfterIndex]} = lists:split(Index-1, Array),
    BeforeIndex ++ [Value2, Value1 | AfterIndex].

test1() ->
    Array = [5,4,3,2,1],
    {SortedArray, Count} = bubble_sort(Array),
    output_message(Array, SortedArray, Count).

test2() ->
    Array = [1,5,2,4,3],
    {SortedArray, Count} = bubble_sort(Array),
    output_message(Array, SortedArray, Count).

output_message(Array, SortedArray, Count) ->
    io:format("Elements before Bubble sort --> ~p~n", [Array]),
    io:format("Elements after Bubble sort --> ~p~n", [SortedArray]),
    io:format("Number of swaps made by Bubble sort --> ~p~n~n", [Count]).
