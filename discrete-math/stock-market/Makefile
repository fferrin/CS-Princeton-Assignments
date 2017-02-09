CFLAGS = -g -Wall -Werror

TARGETS = input invest pattern plot

SRC = ./src
BIN = ./bin

all:	$(TARGETS)

input: 
	gcc $(SRC)/input.c -o $(BIN)/input

invest:
	gcc $(SRC)/invest.c -o $(BIN)/invest

pattern:
	gcc $(SRC)/pattern.c -o $(BIN)/pattern

plot: 
	gcc $(SRC)/plot.c -o $(BIN)/plot

clean:
	rm -f $(SRC)/$(TARGETS) core* *.o