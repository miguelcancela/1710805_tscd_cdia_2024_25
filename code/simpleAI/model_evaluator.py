import numpy as np
import pandas as pd
from sklearn import datasets, linear_model
import csv
import pandas as pd
import numpy as np
import array as arr
import os
import pickle as p1


final_name="dataset_joao"
evaluation_data = pd.read_csv("C:\\uni\\code\\simpleAI\\datasets\\dataset_miguel_test.csv",sep=",",header=None)
data_X=evaluation_data.iloc[:,1:]
data_Y=evaluation_data.iloc[:,0:1]
print(type(evaluation_data))
print(data_X,type(data_X))
print(data_Y,type(data_X))

loaded_model = p1.load(open('./model_predictor', 'rb'))
#print("Coefficients: \n", loaded_model.coef_)

y_pred=loaded_model.predict(data_X[0:1])

data_YC=data_Y.to_numpy()
print("testarY=",len(y_pred),y_pred)
print("***********************")
print("testarX=",type(data_X[0:1]),len(data_X[0:1]),data_X[0:1])
print("***********************")
z_predC=y_pred-data_YC

right=0
wrong=0
total=0
for x in z_predC:
    print(x[0],type(x))
    z=int(x[0])
    total=total+1
    if z==0:
        print(z,x,"right")
        right=right+1
    else:
        print(z,x, "wrong")
        wrong=wrong+1

print(right)
print(wrong)
print("accuraccy right/total= ",right/total)
print("accuraccy wrong/total= ",wrong/total)
