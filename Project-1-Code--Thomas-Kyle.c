#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/*
Kyle Thomas - U0000004031
Applied Cryptography
'Project Vigenere'
Professor Navid

Start Date: 05/24/2018
Finish Date:
*/

void encrypt(char* key);

void decrypt(char* key);

void encrypt(char* key)
{
    printf("Please enter a message up to 150 characters you wish to encrypt: \n");

    char m[150];
    fflush(stdin);
    scanf("%[^\n]%*c", m);
    int count = strlen(m);

    //printf("Key: %c , %c , %c , %c , %c , %c\n", key[0], key[1], key[2], key[3], key[4], key[5]); #debugging

    //Make the input string upper case
    int c = 0;

    while (m[c] != '\0') {
      if (m[c] >= 'a' && m[c] <= 'z') {
         m[c] = m[c] - 32;
      }
      c++;
    }

    //Iterate through the array and add the key based on the index value
    for (int i = 0, j = 0 ; i < count ; i++){
        if (m[i] != ' '){
            m[i] = ((m[i] + key[j]) % 26) + 'A';
            j = ++j %6;
        }
    }

    m[count] = '\0';

    printf("The encrypted string is: \n%s", m);
}

void decrypt(char* key)
{
    printf("Please enter a message up to 150 characters you wish to decrypt: \n");

    char m[150];
    fflush(stdin);
    scanf("%s", m);
    int count = strlen(m);

    //Make the input string upper case
    int c = 0;

    while (m[c] != '\0') {
      if (m[c] >= 'a' && m[c] <= 'z') {
         m[c] = m[c] - 32;
      }
      c++;
    }

    //Iterate through the array and subtract the key based on the index value
    for (int i = 0, j = 0; i < count ; i++){
        if (m[i] != ' '){
            m[i] = (((m[i] - key[j]) + 26) % 26) + 'A';
            j = ++j % 6;
        }
    }

    m[count] = '\0';

    printf("The original message is: \n%s", m);
}

int main(void)
{
    char key[] = "THOMAS";

    int rerun = 1;

    while(rerun == 1){
        printf("\nMenu: Choose an Option:\n"
                "1) Encrypt a Message\n"
                "2) Decrypt a Message\n"
                "3) Change Your Key (Unavailable Feature)\n");

        int *choice = malloc(sizeof(int*));
        scanf("%d", choice);

        switch(*choice)
        {
        case 1:
            encrypt(key);
            break;
        case 2:
            decrypt(key);
            break;
        case 3:
            printf("Error- Feature disabled for this project.\n");
            break;
        default:
            printf("Error- Invalid input. \n");
        }

        printf("\nDo you want to run again? Enter '1' for yes: ");
        fflush(stdin);
        scanf("%d", choice);
    }

    return 0;
}
