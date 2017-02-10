CFLAGS = -g -Wall -Werror

TARGETS = trace cycle

SRC = ./src
BIN = ./bin

all:	$(TARGETS)

trace: 
	gcc $(SRC)/trace.c -o $(BIN)/trace

cycle: 
	gcc $(SRC)/cycle.c -o $(BIN)/cycle

clean:
	rm -f $(SRC)/$(TARGETS) core* *.o