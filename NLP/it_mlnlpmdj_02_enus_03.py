# -*- coding: utf-8 -*-
"""
Created on Mon Jul 15 14:27:32 2019

@author: Welcome
"""



from nltk.corpus import wordnet 
syns = wordnet.synsets("animal")
print(syns)

from nltk.corpus import wordnet
synonyms = []
antonyms = []

for syn in wordnet.synsets("active"):
    for l in syn.lemmas():
        synonyms.append(l.name())
        if l.antonyms():antonyms.append(l.antonyms()[0].name())
        print(set(synonyms))
        print(set(antonyms))