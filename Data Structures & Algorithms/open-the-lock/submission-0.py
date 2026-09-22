class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        if "0000" in deadends:
            return -1

        def children(parent):
            res = []
            
            for i in range(4):
                digit = str((int(parent[i]) + 1) % 10)
                res.append(parent[:i] + digit + parent[i+1:])
                digit = str((int(parent[i]) - 1) % 10)
                res.append(parent[:i] + digit + parent[i+1:])
            return res

        visit = set(deadends)

        q = deque([("0000", 0)])

        while q:
            lock, turn = q.popleft()
            if lock == target:
                return turn
            
            for child in children(lock):
                if child not in visit:
                    visit.add(child)
                    q.append([child, turn + 1])

        return -1
        
