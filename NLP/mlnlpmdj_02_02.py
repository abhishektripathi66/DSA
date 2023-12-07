# -*- coding: utf-8 -*-
"""
Created on Mon Jul 15 01:15:16 2019

@author: Welcome
"""
import nltk
from nltk.stem import SnowballStemmer
snowball = SnowballStemmer(language='english')
print(snowball.stem("cats"))
print(snowball.stem("run"))
print(snowball.stem("running"))
print(snowball.stem("runs"))


from nltk.stem import WordNetLemmatizer
nltk.download('wordnet')
lemmatizer = WordNetLemmatizer()
print("--------------------lemmentized words-------")
print(lemmatizer.lemmatize("mice"))

print(lemmatizer.lemmatize("worst", pos="a"))
print(lemmatizer.lemmatize("best", pos="a"))
print(lemmatizer.lemmatize("jumping",pos="v"))
print(lemmatizer.lemmatize("run",'v'))
  


