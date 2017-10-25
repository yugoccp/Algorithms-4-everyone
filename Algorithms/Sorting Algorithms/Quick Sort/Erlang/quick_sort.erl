-module(quick_sort).
-export([main/0, quick_sort/1]).

main() ->
    test1(),
    test2().   
%% Uses list comprehension to sort list
quick_sort([Pivot|Rest]) ->
    %% Get all elements that are smaller than the pivot and call quicksort on this list
    %% Get all elements that are larger/equal to the pivot and call quicksort on this list
    %% Build the final list using both sorted lists
    quick_sort([ X || X <- Rest, X < Pivot]) ++
    [Pivot] ++
    quick_sort([ X || X <- Rest, X >= Pivot]);

quick_sort([]) -> [].

test1() ->
    Array = [5,4,3,2,1],
    SortedArray = quick_sort(Array),
    output_message(Array, SortedArray).

test2() ->
    Array = [1,5,2,4,3],
    SortedArray = quick_sort(Array),
    output_message(Array, SortedArray).

output_message(Array, SortedArray) ->
    io:format("Elements before Quick sort --> ~p~n", [Array]),
    io:format("Elements after Quick sort --> ~p~n~n", [SortedArray]).
