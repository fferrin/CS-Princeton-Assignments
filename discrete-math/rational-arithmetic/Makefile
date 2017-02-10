CFLAGS = -g -Wall -Werror

TARGETS = e e_better

SRC = ./src
INCLUDE = ./include
BIN = ./bin

all:	$(TARGETS)

e: 
	gcc $(SRC)/e.c $(SRC)/rat.c -o $(BIN)/e

e_better: 
	gcc $(SRC)/e.c $(SRC)/ratbetter.c -o $(BIN)/e_better

clean:
	rm -f $(SRC)/$(TARGETS) core* *.o