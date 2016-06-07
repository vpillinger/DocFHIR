README

In order to test the final output of DocFhir:

1) Add docgraph test data to the test inputs folder

2) Add an expected result to test expected outputs folder. 
	Use the same filename as your input file, whitespace will be ignored.
	If you do not specify an expected output, then the file will be converted
	but the testing will skip verifying the programs output as correct.