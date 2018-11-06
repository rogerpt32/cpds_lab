-module(pingpong).
-export([start/0, ping/2, pong/0]).

start() ->
    Pong_PID = spawn(..., pong, []),
    spawn(..., ping, [3, Pong_PID]).
ping(0, Pong_PID) ->
    Pong_PID ! finished,
    io:format("Ping finished~n", []);
ping(N, Pong_PID) ->
    Pong_PID ! {ping, ...},
    .....
    .....
    .....
pong() ->
    receive
        finished ->
            io:format("Pong finished~n", []);
        {ping, ...} ->
            io:format("Pong received ping~n", []),
            ....
            ....
    end.