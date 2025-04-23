
import pandas as pd

import pickle as p1

data_X=input("introduza valores a avaliar\n")

my_list = data_X.split(",")
res = [eval(i) for i in my_list]
print(my_list,type(my_list))
print(res,type(res),len(res))

df = pd.DataFrame(res)

loaded_model = p1.load(open('./model_predictor', 'rb'))

y_pred=loaded_model.predict(df.transpose())

print("number predictor: ", int(y_pred[0]))

print("FIM")
