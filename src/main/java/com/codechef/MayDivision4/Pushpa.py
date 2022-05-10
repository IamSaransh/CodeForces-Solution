
        def fooBar(List):
        return max(set(List), key=List.count)


        t = int(input())

        for i in range(0, t):
        n = int(input())
        a = list(map(int, input().split()))
        xxx = fooBar(a) + a.count(fooBar(a))-1
        yyy = max(a) + a.count(max(a)) - 1
        if xxx > yyy:
        print(xxx)
        else:
        print(yyy)