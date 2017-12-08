#define _CRT_SECURE_NO_WARNINGS
#define MAX 500
#define STRLENGTH 100
#include <stdio.h>
#include <string.h>
#include <windows.h>
#include <conio.h>

struct info
{
	char name[STRLENGTH];
	char phone[STRLENGTH];
	double cp, is, net;
	double avg;
};

void load(struct info *data, int *count)
{
	FILE *fp = fopen("save.txt", "r");
	if (fp == NULL) {
		return;
	}
	while (1)
	{
		if (fscanf(fp, "%s", data[*count].name) == EOF) {
			break;
		}
		fscanf(fp, "%s", data[*count].phone);
		fscanf(fp, "%lf", &data[*count].cp);
		fscanf(fp, "%lf", &data[*count].is);
		fscanf(fp, "%lf", &data[*count].net);
		fscanf(fp, "%lf", &data[*count].avg);
		data[*count].avg = (data[*count].cp + data[*count].is + data[*count].net)/3; 
		(*count)++;
	}
	fclose(fp);
}

void save(struct info *data, int count)
{
	FILE *fp = fopen("save.txt", "w");
	int i;


	for (i = 0; i < count; i++)
		fprintf(fp, "%s %s %.0f %.0f %.0f %.2f\n", 
			data[i].name, data[i].phone, data[i].cp, data[i].is, data[i].net, data[i].avg);
	fclose(fp);
}

int main() {
	system("tItlE ��������");
	system("CoLOr f0");
	system("mode con:cols=96 lines=20");

	{
		struct info data[MAX];
		int count = 0;
		char cphone[STRLENGTH];
		int i, j;
		double ccp, cis, cnet;
		int choice;
		char find[STRLENGTH];
		boolean start = true;
		load(data, &count);
		while (start)
		{
			printf("\t\t\t\t\t---�޴�---\n");
			printf("\t\t\t\t\t1.�Է�\n");
			printf("\t\t\t\t\t2.����\n");
			printf("\t\t\t\t\t3.���\n");
			printf("\t\t\t\t\t4.����\n");
			printf("\t\t\t\t\t5.����\n");
			printf("\t\t\t\t\t6.����\n");
			printf("\t\t\t\t\t-> ");
			scanf("%d", &choice);
		
			if (choice == 1) // �Է�
			{
				system("cls");
				printf("\t\t\t\t\t---�����Է�---\n");
				printf("\t\t\t\t\t�̸� :");
				scanf("%s", data[count].name);
				printf("\t\t\t\t\t��ȭ��ȣ :");
				scanf("%s", data[count].phone);
				printf("\t\t\t\t\tC��� ����:");
				scanf("%lf", &data[count].cp);
				printf("\t\t\t\t\t�������� ����:");
				scanf("%lf", &data[count].is);
				printf("\t\t\t\t\t��Ʈ��ũ ����:");
				scanf("%lf", &data[count].net);
				data[count].avg = (data[count].cp + data[count].is + data[count].net)/3;
				count++;

				printf("\t\t\t\t\t������ �ԷµǾ����ϴ�.");
			}
			else if (choice == 2) { // ����
				save(data, count);
				printf("\t\t\t\t\t������ ����Ǿ����ϴ�.");
			}
			else if (choice == 3) { // ���
				system("cls");
				printf("\t\t\t\t\t---���---\n");		
				printf("------------------------------------------------------------------------------------------------\n");
				printf("�� ��\t ��ȭ��ȣ\t C �� ��\t ��������\t ��Ʈ��ũ\t ���\t\t ���\n");
				printf("------------------------------------------------------------------------------------------------\n");
				for (i = 0; i < count; i++) {
					if (data[i].avg >= 90) {
						printf("%s\t %s\t %.0f\t\t %.0f\t\t %.0f\t\t %.2f\t\t A\n",
							data[i].name, data[i].phone, data[i].cp, data[i].is, data[i].net, data[i].avg);
					} 

					else if (data[i].avg >= 80 && data[i].avg <90) {
						printf("%s\t %s\t %.0f\t\t %.0f\t\t %.0f\t\t %.2f\t\t B\n",
							data[i].name, data[i].phone, data[i].cp, data[i].is, data[i].net, data[i].avg);
					}
					else if (data[i].avg >= 70 && data[i].avg <80) {
						printf("%s\t %s\t %.0f\t\t %.0f\t\t %.0f\t\t %.2f\t\t C\n",
							data[i].name, data[i].phone, data[i].cp, data[i].is, data[i].net, data[i].avg);
					}
					else if (data[i].avg >= 60 && data[i].avg < 70) {
						printf("%s\t %s\t %.0f\t\t %.0f\t\t %.0f\t\t %.2f\t\t D\n",
							data[i].name, data[i].phone, data[i].cp, data[i].is, data[i].net, data[i].avg);
					}
					else {
						printf("%s\t %s\t %.0f\t\t %.0f\t\t %.0f\t\t %.2f\t\t F\n",
							data[i].name, data[i].phone, data[i].cp, data[i].is, data[i].net, data[i].avg);
					}
				}
				printf("\n\t\t\t\t\t����� �Ϸ� �Ǿ����ϴ�.\n");
			}
			else if (choice == 4) { // ����
				system("cls");
				printf("\t\t\t\t\t---����---\n");
				printf("--------------------------------------------------------------------------------------\n");
				printf("�� ��\t ��ȭ��ȣ\t C �� ��\t ��������\t ��Ʈ��ũ\t ���\t\t\n");
				printf("--------------------------------------------------------------------------------------\n");
					for (i = 0; i <count; i++) {
						printf("%s\t %s\t %.0f\t\t %.0f\t\t %.0f\t\t %.2f\t\t\n",
							data[i].name, data[i].phone, data[i].cp, data[i].is, data[i].net, data[i].avg);
						}
				printf("\t\t\t\t\t������ �̸� �Է�\n");
				printf("\t\t\t\t\t-> ");
				scanf("%s", find);
		
				
				for (i = 0; i < count; i++)
				{
					if (strcmp(data[i].name, find) == 0)
					{
						for (j = i; j < count - 1; j++)
							data[j] = data[j + 1];
						count--;
					}
				}
				printf("\n\t\t\t\t\t�����Ǿ����ϴ�.\n");
			}

			else if (choice == 5) { // ����
				system("cls");
				printf("\t\t\t\t\t---����---\n");
				printf("\t\t\t\t\t������ �̸� �Է�\n");
				printf("\t\t\t\t\t-> ");
				scanf("%s", find);
				printf("--------------------------------------------------------------------------------------\n");
				printf("�� ��\t ��ȭ��ȣ\t C �� ��\t ��������\t ��Ʈ��ũ\t ���\t\t\n");
				printf("--------------------------------------------------------------------------------------\n");
				for (i = 0; i <count; i++) {
					if (strcmp(data[i].name, find) == 0)
					{
						printf("%s\t %s\t %.0f\t\t %.0f\t\t %.0f\t\t %.2f\t\t\n",
							data[i].name, data[i].phone, data[i].cp, data[i].is, data[i].net, data[i].avg);
						strcpy(data[i].name, find);
						printf("\n\t\t\t\t\t���� �� ��ȭ��ȣ : ");
						scanf("%s", cphone);
						strcpy(data[i].phone, cphone);
						printf("\t\t\t\t\t���� �� C��� ���� :");
						scanf("%lf", &ccp);
						data[i].cp = ccp;
						printf("\t\t\t\t\t���� �� �������� ���� :");
						scanf("%lf", &cis);
						data[i].is = cis;
						printf("\t\t\t\t\t���� �� ��Ʈ��ũ ���� :");
						scanf("%lf", &cnet);
						data[i].net = cnet;
						data[i].avg = (data[i].cp + data[i].is + data[i].net) / 3;
					}
				}
				printf("\n\t\t\t\t\t���� �Ǿ����ϴ�.\n");
			}
			else if(choice == 6){ // ����
				start = false;
				printf("\n\t\t\t\t\t���α׷� ����\n");
			}
			_getch();
			system("cls");
		}
		return 0;
	}
}
