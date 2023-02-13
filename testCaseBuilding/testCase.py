import random

lines = [] # 한줄한줄 저장하는 배열

T = 3
lines.append(f'{T}')
for tc in range(1, T+1):
  N = random.randint(1, 100)
  M = random.randint(1, 100)
  K = random.randint(1, 100)
  lines.append(f'{N} {M} {K}')

  arr = []
  for _ in range(N):
    num = random.randint(0, 11111)
    arr.append(f'{num}')
  lines.append(" ".join(arr))

print("\n".join(lines))

with open("sample_input.txt", "w") as f:
  f.write("\n".join(lines))
