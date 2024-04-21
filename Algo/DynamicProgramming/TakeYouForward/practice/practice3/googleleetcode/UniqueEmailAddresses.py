from typing import List
class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        myset = set()
        for email in emails:
            myset.add(self.getStrippedEmail(email))
        
        return len(myset)


    def getStrippedEmail(self,email:str) -> str:
        spliteemail= email.split('@')
        localname=spliteemail[0]
        domainname= spliteemail[1]
        localname= localname.split('+')[0]
        localname=localname.replace('.','')
        email=localname+'@'+domainname
        return email

emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
sol = Solution()
print(sol.numUniqueEmails(emails))