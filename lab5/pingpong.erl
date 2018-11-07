-module(pingpong).
-export([start/0, ping/2, pong/0]).

start() ->
    Pong_PID = spawn(pingpong, pong, []),
    spawn(pingpong, ping, [3, Pong_PID]).
ping(0, Pong_PID) ->
    Pong_PID ! finished,
    io:format("Ping finished~n", []);
ping(N, Pong_PID) ->
    Pong_PID ! {ping, self()},
    receive
        pong ->
            io:format("Ping recieved pong~n", []),
            ping(N-1, Pong_PID)
    end.
pong() ->
    receive
        finished ->
            io:format("Pong finished~n", []);
        {ping, Pid} ->
            io:format("Pong received ping~n", []),
            Pid ! pong,
            pong()
    end.