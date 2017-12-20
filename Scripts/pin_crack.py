import hashlib
import time
start_time = time.time()
x=raw_input("Enter the Hash to Crack: ")
for i in range(1111,999999):
	m = hashlib.md5()
	m.update(str(i))
	hash = m.hexdigest()
	if hash == x:
		print "Hash Cracked!\nMD5("+str(i)+") = "+ hash
		print "Cracked in " + str(time.time() - start_time) + " milliseconds"
		print "Pin is: " + str(i)
		break