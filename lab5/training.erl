-module(training).
-compile(export_all).

pyth(N) ->
    [ {A,B,C} ||
        A <- lists:seq(1,N),
        B <- lists:seq(1,N),
        C <- lists:seq(1,N),
        A+B+C =< N,
        A*A+B*B == C*C ].

range(N, N) -> [N];
range(Min, Max) -> [Min | range(Min+1, Max)].
