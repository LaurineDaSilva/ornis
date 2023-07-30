# Needs Analysis

## Data Model

## Bird entity

![Ornis - Bird ER diagram](https://user-images.githubusercontent.com/107263089/236669502-8c1eb998-ad4c-4c0c-a61b-c605f083d224.jpg)

## Data Dictionary

### Bird list display

- In database:

|Conceptual Name | Generic Data Type | Management Rules |
|----------------|-------------------|------------------|
|Species code    | TEXT              | required, alphanum, length [1, 100], unique for a given bird|
|Scientific name | TEXT              | required, alphanum, length [1, 100], unique for a given bird|


- In JSON (i18n):

|Conceptual Name | Generic Data Type | Management Rules |
|----------------|-------------------|------------------|
|Species code    | TEXT              | required, alphanum, length [1, 100], unique for a given bird|
|Vernacular name | TEXT              | required, alphanum, length [1, 100], unique for a given bird|

- In front-end's images folder: 

|Conceptual Name | Generic Data Type | Management Rules |
|----------------|-------------------|------------------|
|Image URL       | TEXT              | required, alphanum, length [1, 255], unique for a given bird| 
