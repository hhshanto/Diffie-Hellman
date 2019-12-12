class PrimitiveRoot:
    def __init__(self, p):
        self.p = p
        print(f"The entered value is {p}")
        result = []
        for i in range(p):
            arr = []
            print(f"{i} ->", end=" ")
            for j in range(p - 1):
                res = pow(i, j)
                res = res % p
                arr.append(res)
                print(res, end=" ")
            check = self.primitiveCheck(arr)
            if check == 0:
                print("\tNot Primitive")
            else:
                print("\tPrimitive")
                result.append(i)
        lengt = len(result)
        print(f"Primitive roots are: ", end="")
        for a in range(lengt):
            print(f" {result[a]}", end=" ")

    def primitiveCheck(self, arr):
        length = len(arr)
        for x in range(length):
            for y in range(length):
                if arr[x] == arr[y] and x != y:
                    return 0
        return 1


while 1:
    prime = int((input("Enter a  number: ")))
    flag = True
    for i in range(2, prime):
        if (prime % i) == 0:
            flag = False
            break
    if flag:
        pr = PrimitiveRoot(prime)
        break
    else:
        print(f"{prime} is not a  number")
