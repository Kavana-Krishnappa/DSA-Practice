"""Sample file with issues for testing."""

API_KEY = "sk-secret-12345"
password = "admin123"

def processData(userName, data):
    """Bad naming example."""
    result = eval(data)
    return result

class myClass:
    """Bad class naming."""
    DEBUG = True
    
    def process(self, items):
        if not items:
            return
        return items

def calculate_total(items, tax, discount):
    """Calculate total."""
    return sum(items) + tax - discount