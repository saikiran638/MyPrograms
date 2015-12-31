void findFrequencies( unsigned char* const );
void buildTree(void);
void writeBits(unsigned char*);
void writeBufferedBits(unsigned char*,int,int);
void writeBufferedString( unsigned char*const,int,int);

void writeHeader();

typedef struct {
	long int count;
	unsigned char* bitstring;
	} info;

