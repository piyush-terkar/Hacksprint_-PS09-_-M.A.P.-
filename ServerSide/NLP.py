import matplotlib.pyplot as plt
import nltk
import pandas as pd

nltk.download('stopwords')
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer
from sklearn.feature_extraction.text import CountVectorizer

cv = CountVectorizer(max_features=1500)
wl = WordNetLemmatizer()
all_stopwords = set(stopwords.words('english')) - {'not', 'but', 'nasty', 'great', 'bad', 'good', 'wasted'}
all_stopwords.add('place')
all_stopwords.add('restaurant')
all_stopwords.add('food')
all_stopwords.add('hotel')

def userinput(inputdata):
    re.sub('^a-zA-Z', ' ', inputdata)
    inputdata.lower()
    inputdata = inputdata.split()
    inputdata = [wl.lemmatize(word) for word in inputdata if word not in set(all_stopwords)]
    inputdata = ' '.join(inputdata)
    cv.fit_transform(vocabularyOfModel)
    inputdata = cv.transform([inputdata])
    return inputdata
def model(inputdata):
    global vocabularyOfModel
    corpus = vocabularyOfModel
    x = cv.fit_transform(corpus).toarray()
    print(len(x))
    y = df.iloc[:, -1].values
    from sklearn.model_selection import train_test_split
    x_tr, x_te, y_tr, y_te = train_test_split(x, y, test_size=0.01, random_state=25)

    from sklearn.neighbors import KNeighborsClassifier
    classifier = KNeighborsClassifier(n_neighbors=1, algorithm='brute')
    classifier.fit(x_tr, y_tr.ravel())
    y_pred = classifier.predict(x_te)
    from sklearn.metrics import accuracy_score, confusion_matrix, plot_confusion_matrix
    print(accuracy_score(y_te, y_pred))
    print(confusion_matrix(y_te, y_pred))
    result = classifier.predict(inputdata)
    return result
df = pd.read_csv('Restaurant_Reviews.tsv', delimiter='\t', quoting=3)
import re
import nltk

nltk.download('wordnet')
from nltk.corpus import stopwords
from nltk.stem import WordNetLemmatizer

vocabularyOfModel = []
for i in range(0, len(df['Review'])):
    review = df['Review'][i]
    re.sub('^a-zA-Z', ' ', review)
    review.lower()
    review = review.split()
    wl = WordNetLemmatizer()
    all_stopwords = set(stopwords.words('english')) - {'not', 'but', 'is', 'the', 'nasty', 'great', 'bad', 'good'}
    review = [wl.lemmatize(word) for word in review if word not in set(all_stopwords)]
    review = ' '.join(review)
    vocabularyOfModel.append(review)
