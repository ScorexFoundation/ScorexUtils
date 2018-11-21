package scorex.util.serialization


trait Reader {

  type CH

  def newReader(chunk: CH): Reader.Aux[CH]

  def getChunk(size: Int): CH

  /**
    * Decode String is shorter than 256 bytes
    * @return
    */
  def getShortString(): String
  /**
    * Get a byte at current position without advancing the position.
    * @return byte at current position
    */
  def peekByte(): Byte
  def getByte(): Byte
  def getUByte(): Int
  def getShort(): Short

  /**
    * Decode positive Short.
    * @return signed Int
    */
  def getUShort(): Int

  /**
    * Decode signed Int.
    * @return signed Int
    */
  def getInt(): Int

  /**
    * Decode positive Int.
    * @return signed Long
    */
  def getUInt(): Long

  /**
    * Decode signed Long.
    * @return signed Long
    */
  def getLong(): Long

  /**
    * Decode positive Long.
    * @return signed Long
    */
  def getULong(): Long

  def getBytes(size: Int): Array[Byte]

  /**
    * Decode array of boolean values
    * @param size expected size of decoded array
    * @return decoded array of boolean values
    */
  def getBits(size: Int): Array[Boolean]
  def getOption[T](getValue: => T): Option[T]
  def mark(): this.type
  def consumed: Int
  def position: Int
  def position_=(p: Int): Unit
  def remaining: Int
}

object Reader {
  type Aux[CCH] = Reader{ type CH = CCH }
}

