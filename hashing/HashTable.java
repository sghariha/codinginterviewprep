public class HashTable {
  private String[] keyTable;
  private int[] valueTable;
  private int entries;

  public HashTable() {
    this.keyTable = new String[5];
    this.valueTable = new int[5];
    this.entries = 0;
  }

  public static void main(String args[]) {
    // Test adding 4 entries and removing one existing entry
    HashTable ht = new HashTable();
    ht.insert("first", 5);
    ht.insert("second", 6);
    ht.insert("third", 7);
    ht.insert("fourth", 8);
    ht.insert("fifth", 8);
    System.out.println(ht.toString());
    boolean isRemoved = ht.delete("fifth");
    System.out.println(ht.toString());
  }

  // Generate hashed index within table boundaries
  public int hashFunction(String key, int mod) {
    return Math.abs(key.hashCode() % mod);
  }

  // Insert key and value pair using open addressing for hash collision resolution
  public void insert(String key, int value) {
    if (this.entries / this.keyTable.length >= 0.70) {
      String[] keyTableNew = new String[this.keyTable.length * 2];
      int[] valueTableNew = new int[this.valueTable.length * 2];
      for (int k = 0; k < this.keyTable.length; k++) {
        if (this.keyTable[k] != null) {
          int insertIndex = hashFunction(this.keyTable[k], keyTableNew.length);
          while (keyTableNew[insertIndex] != null) {
            insertIndex = (insertIndex + 1) % keyTableNew.length;
          }
          keyTableNew[insertIndex] = keyTable[k];
          valueTableNew[insertIndex] = valueTable[k];
        }
      }
      this.keyTable = keyTableNew;
      this.valueTable = valueTableNew;

    }
    int insertIndex = hashFunction(key, this.keyTable.length);
    while (this.keyTable[insertIndex] != null) {
      if (this.keyTable[insertIndex].equals(key)) {
        return;
      }
      insertIndex = (insertIndex + 1) % this.keyTable.length;
    }
    this.keyTable[insertIndex] = key;
    this.valueTable[insertIndex] = value;
    this.entries++;
  }

  // Look up entry in table and return -1 if not found
  // TODO: throw + handle exceptions for keys not found
  public int lookup(String key) {
    int ticker = 0;
    int index = hashFunction(key, this.keyTable.length);
    while (!this.keyTable[index].equals(key)) {
      if (ticker >= this.keyTable.length) {
        return -1;
      }
      index = (index + 1) % this.keyTable.length;
      ticker++;
    }
    return this.valueTable[index];
  }

  // Delete entry and return false if entry doesn't exist
  public boolean delete(String key) {
    int ticker = 0;
    int index = hashFunction(key, this.keyTable.length);
    while (!this.keyTable[index].equals(key)) {
      if (ticker >= this.keyTable.length) {
        return false;
      }
      index = (index + 1) % this.keyTable.length;
      ticker++;
    }
    this.keyTable[index] = null;
    this.valueTable[index] = 0;
    return true;
  }

  // Comma separated list of entries in order of indices (least to greatest)
  public String toString() {
    StringBuilder pairs = new StringBuilder();
    for (int k = 0; k < this.keyTable.length; k++) {
      if (this.keyTable[k] != null) {
        pairs.append(this.keyTable[k] + " : " + this.valueTable[k] + ", ");
      }
    }
    return pairs.toString();
  }
}