import math

def logLossBinary(actual, predict, prob):
    result = 0.
    numAnswers = len(actual)
    for i in range(numAnswers):
        if (predict[i] == 0):
            prob[i] = 1 - prob[i]
        result += -1. * (actual[i] * math.log(prob[i]) + (1. - actual[i]) * math.log(1 - prob[i]))
    return result / float(numAnswers)


true_answers = [1., 0.]
pete_answers = [1., 1.]
petes_probs = [0.5, 0.5]
igors_answers = [1., 0.]
igors_probs = [1., .99]
print(logLossBinary(true_answers, pete_answers, petes_probs))
print(logLossBinary(true_answers, igors_answers, igors_probs))
