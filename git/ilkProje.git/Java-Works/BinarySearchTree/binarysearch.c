/*
 * binarysearch.c
 *
 *  Created on: Dec 26, 2018
 *      Author: zeynepoztemur
 */

#include <stdio.h>
#include <stdlib.h>

struct n {
	int data;
	struct n * sol;
	struct n * sag ;
};
typedef struct n * node;

//struct node * agac = (struct node*)malloc(sizeof(node));

node * ekle(struct n *agac , int x){
	if(agac == NULL){
		struct n * root = (struct node*)malloc(sizeof(node));
		root->sag = NULL ;
		root->sol = NULL ;
		root->data = x ;
		return root;
	}
	if (agac->data < x){
		agac->sag = ekle(agac->sag , x);
		return agac ;
	}
	agac->sol = ekle(agac->sol , x );
	return agac;
}

void dolas(struct n * agac){
	if(agac == NULL){
		return;
	}
	dolas(agac->sag);
	printf("%d ", agac->data);
	dolas(agac->sol);
}
int bul( struct n * agac , int aranan){
	if(agac == NULL)
		return -1;
	if(agac->data == aranan)
		return 1 ;
	if (bul(agac->sag, aranan)== 1)
		return 1;
	if (bul(agac->sol, aranan)== 1)
			return 1;
	return -1;
}

int main(){
	struct n * agac = NULL ;
	agac  = ekle(agac ,12);
	agac  = ekle(agac ,14);
	agac  = ekle(agac ,35);
	agac  = ekle(agac ,10);
	agac  = ekle(agac ,98);
	agac  = ekle(agac ,203);
	dolas(agac);

	int i = bul(dolas,12);

	if(i==1){
		printf("Deger VAR.");
	}
	else printf("Deger YOK.");



}

