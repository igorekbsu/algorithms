activities = [(1, 4), (3, 5), (0, 6), (5, 7), (3, 9), (5, 9), (6, 10), (8, 11), (8, 12), (2, 14), (12, 16)]

def select_compatible(activities):
    compatible, last_finish = [activities[0]], activities[0][1]
    for i in range(1, len(activities)):
        start_time, finish_time = activities[i]
        if last_finish < start_time:
            compatible.append(activities[i])
            last_finish = finish_time
    return compatible

print(select_compatible(activities))
  