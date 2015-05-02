def main():
  nums = [2, 3, 2, 3, 3, 4, 5, 4, 2, 2, 5, 6]
  print "Numbers: " + str(nums)

  if len(nums) == 0:
    return  None

  xorNums = getXor(nums)

  print 'xorNums = ' + str(xorNums)
  bitPos = getFirstSetBitPosition(xorNums)

  xorNums0 = None
  xorNums1 = None

  for i in nums:
    if getBitAtPosition(i, bitPos) == 0:
      if xorNums0 == None:
        xorNums0 = i
      else:
        xorNums0 ^= i
    else:
      if xorNums1 == None:
        xorNums1 = i
      else:
        xorNums1 ^= i

  print 'xorNums0 = ' + str(xorNums0)
  print 'xorNums1 = ' + str(xorNums1)


def getXor(numbers):
  xorNums = None
  for i in numbers:
    if xorNums is None:
      xorNums = i
    else:
      xorNums = xorNums ^ i
  return xorNums


def getFirstSetBitPosition(number):
  if (number == 0):
    return None

  bitPos = 0
  xorNums = number

  while (xorNums & 1) == 0:
    bitPos += 1
    xorNums = xorNums >> 1
  return bitPos


def getBitAtPosition(number, position):
  return ((number >> position) & 1)

if __name__ == "__main__":
  main()

