#Question 1



num= input("enter your id number please: ")
while len(num) > 13 or len(num) < 13:
	num = input("the length of that ID number is wrong, please enter your valid 13 digits SA Id number please: ")
	 

prev_number = 0
prev_string= ""



for index in  range(0,11,2):
	A=prev_number + int(num[index])
	prev_number=A

for index in range(1,12,2):
	B = prev_string + str(num[index])
	prev_string = B

x = 2 * int(B)

prev_number=0

for number in str(x) :
	C = prev_number + int(number)
	prev_number = C

D = A + C

if (10 - (D % 10)) == int(num[12]) :
	print("This is a  Valid South African ID number")
else:
	print("This is not a  Valid South African ID number")










