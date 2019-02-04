First change the working directory to the project root directory rate_calculator, and then run:
mvn clean install

To start the application use this command:
mvn spring-boot:run -Dspring-boot.run.arguments=[sum to be borrowed],[csv file]

An example usage would be:
mvn spring-boot:run -Dspring-boot.run.arguments=1000.0,lenders.csv

If arguments are not specified, then the default values will be taken from application.properties
which would be 
requestedAmount=1000.0
lendersFile=lenders.csv

Another way to start the application would be directly running it from InteliJ.

The file lenders.csv is in the root of the project, for simpler use if file is not specified.

Other configurable properties are the loan period length which has a default value of 36, the locale used
for currency and the calculation formula that can be used which also has a default value.

As for the stricture of the project the packages included contain:
- calculator: going through the list of lenders provided from the file and finding out which ones have 
enough money to borrow. Enum with a few methods of calculating monthly rate found from various websites, and
implementation of the rate calculation for all of those formulas. Unfortunately, in the example you provided
the monthly payment was supposed to be 30.88 and nowhere have I found a formula that can reach that number, 
but I hope the exercise was not about a specific formula so I provided more formulas.
- loader: here there is an interface that can be used to load data for lenders and one implementation of it which
is reading csv files. Of course it can have different implementations depending on the requirements.
- model: here are the models of lenders and quote which is the final representation of the result that is printed, 
this package also includes a singleton formatter for the currency
- processor: here is the logic about calculating monthly rates and total payment

As addition I have used a Mongo db to save the calculated quotes, once the application is started they can be
accessed on http://localhost:8080/quotes and as the application starts there is only one quote available, 
I have not provided endpoints to add new quotes. The packages are organised in the following way:
- repository: interface that implements ReactiveMongoRepository 
- controller: a rest endpoint implementation for getting the quotes


The test coverage is 100%