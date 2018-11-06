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
range(Min, Max) when Min > Max -> [];
range(Min, Max) when Min < Max -> [Min | range(Min+1, Max)].

remove_multiples(N, [H|T]) when H rem N == 0 -> remove_multiples(N,T);
remove_multiples(N, [H|T]) -> [H|remove_multiples(N,T)];
remove_multiples(_, []) -> [].

sieve([H|T]) -> [H | sieve(remove_multiples(H, T))];
sieve([]) -> [].

primes(Max) -> sieve(range(2, Max)).
